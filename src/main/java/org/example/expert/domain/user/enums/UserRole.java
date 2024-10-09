package org.example.expert.domain.user.enums;

import org.example.expert.domain.common.exception.InvalidRequestException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public enum UserRole {
    ADMIN, USER;

    public static UserRole of(String role) {
        return Arrays.stream(UserRole.values())
                .filter(r -> r.name().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(() -> new InvalidRequestException("유효하지 않은 UerRole"));
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 역할 이름을 권한으로 변환 (예: "ROLE_ADMIN", "ROLE_USER")
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_User" + this.name()));
    }
}
