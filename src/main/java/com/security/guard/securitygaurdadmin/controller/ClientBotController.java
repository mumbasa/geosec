package com.security.guard.securitygaurdadmin.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.github.kshashov.telegram.api.MessageType;
import com.github.kshashov.telegram.api.TelegramMvcController;
import com.github.kshashov.telegram.api.TelegramRequest;
import com.github.kshashov.telegram.api.bind.annotation.BotPathVariable;
import com.github.kshashov.telegram.api.bind.annotation.BotRequest;
import com.github.kshashov.telegram.api.bind.annotation.request.MessageRequest;
import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.security.guard.securitygaurdadmin.models.Attendance;
import com.security.guard.securitygaurdadmin.models.Guard;
import com.security.guard.securitygaurdadmin.service.AttendanceService;
import com.security.guard.securitygaurdadmin.service.GuardService;

//@BotController
public class ClientBotController implements TelegramMvcController {
	@Autowired
	GuardService guardService;

	@Autowired
	AttendanceService attendanceService;

	@Value("${bot2.token}")
	private String token;

	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		return token;
	}

	@BotRequest(value = "/ds", type = { MessageType.CALLBACK_QUERY, MessageType.MESSAGE })
	public BaseRequest hellos(User user, Chat chat, Message me) {
		if (me.location() == null) {

			return new SendMessage(chat.id(), "Hello, " + me.document().fileName());

		} else {
			Optional<Guard> guard = guardService.findGuard(chat.id());

			if (guard.isPresent()) {
				try {
					if (me.location().livePeriod() > 0 | me.replyToMessage().text().equalsIgnoreCase("Choose Method")) {
						Attendance attend = attendanceService.getStaffRecentAttendance(guard.get().getId()).get();
						if (attend.getTimeOut() == null) {

							Attendance attendance = new Attendance();
							attendance.setGuard(guard.get());
							attendance.setTimeIn(LocalDateTime.now());

							return new SendMessage(chat.id(), "Hello, Attendance Logged");

						} else {
							attend.setTimeOut(LocalDateTime.now());
							return new SendMessage(chat.id(), "something, Else Logged");

						}

					}
				} 
				catch (NullPointerException e) {
					return new SendMessage(chat.id(), "Dont send direct loaction please");
				}}
			
			else {

				return new SendMessage(chat.id(), "Hello, you can not use this service");

			}

		}
		return null;
	}

	@MessageRequest("/hell {name:[\\S]+}")
	public String helloWithName(@BotPathVariable("name") String userName) {
		// Return a string if you need to reply with a simple message
		return "Hello, " + userName;
	}

	@MessageRequest("/helloCallback")
	public String helloWithCustomCallback(TelegramRequest request, User user) {
		request.setCallback(new Callback() {
			@Override
			public void onResponse(BaseRequest request, BaseResponse response) {
				// TODO

			}

			@Override
			public void onFailure(BaseRequest request, IOException e) {
				// TODO
			}
		});
		return "Hello, " + user.firstName() + "!";
	}

	@MessageRequest("/register {name:[\\S]+}")
	public BaseRequest<?, ?> helloWithNe(@BotPathVariable("name") String userName, Chat chat) {
		// Return a string if you need to reply with a simple message
		Optional<Guard> staff = guardService.findGuard(userName);
		if (staff.isPresent()) {
			if (staff.get().getTelegramId() < 1) {
				staff.get().setTelegramId(chat.id());
				guardService.saveGuard(staff.get());
				return new SendMessage(chat.id(), "Hello, " + staff.get().getLastName() + " "
						+ staff.get().getFirstName() + " registration complete!");
			} else {

				return new SendMessage(chat.id(), "Hello, " + staff.get().getLastName() + " "
						+ staff.get().getFirstName() + " already completed!");

			}
		} else {
			return new SendMessage(chat.id(), "Hello,  you are not eligble for this service !");

		}

	}

	@BotRequest(value = "/punch", type = { MessageType.CALLBACK_QUERY, MessageType.MESSAGE })
	public BaseRequest<?, ?> hellol(User user, Chat chat, TelegramRequest req) {
		KeyboardButton clockIn = new KeyboardButton("Clock In");
		KeyboardButton clockOut = new KeyboardButton("Clock Out");
		KeyboardButton[] kbs = { clockIn, clockOut };
		clockIn.requestLocation(true);
		clockOut.requestLocation(true);

		ReplyKeyboardMarkup rk = new ReplyKeyboardMarkup(kbs);
		rk.resizeKeyboard(true);
		SendMessage ks = new SendMessage(chat.id(), "Choose Method");
		ks.replyToMessageId(2);
		ks.replyMarkup(rk);
		ks.replyToMessageId(req.getMessage().messageId());

		return ks;
	}
}
