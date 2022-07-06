package com.security.guard.securitygaurdadmin.configuration;

public enum AdminUserPermission {
	SUPERVISOR_OPERATION("admin:super"), CLIENT_OPERATION("client:super"), GUARD_OPERATION("guard:super"), ADMIN_OPERATION("admin:super"),
	SUPERVISOR_READ("admin:read"), CLIENT_READ("client:read"), GUARD_READ("guard:read");
	;

	private String permission;

	public String getPermission() {
		return permission;
	}

	private AdminUserPermission(String permission) {
		this.permission = permission;
	}


}
