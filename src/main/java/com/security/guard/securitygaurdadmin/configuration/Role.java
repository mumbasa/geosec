package com.security.guard.securitygaurdadmin.configuration;

import java.util.Set;

public enum Role {
	ADMIN(Set.of(AdminUserPermission.ADMIN_OPERATION)),
	MANAGER(Set.of(AdminUserPermission.GUARD_OPERATION, AdminUserPermission.CLIENT_OPERATION)),
	SUPERVISOR(Set.of(AdminUserPermission.GUARD_OPERATION)),
	SUPERADMIN(Set.of(AdminUserPermission.GUARD_OPERATION, AdminUserPermission.CLIENT_OPERATION));

	private Set<AdminUserPermission> permission;

	private Role(Set<AdminUserPermission> permission) {
		// TODO Auto-generated constructor stub
		this.permission = permission;
	}

	public Set<AdminUserPermission> getPermission() {
		return permission;
	}
}
