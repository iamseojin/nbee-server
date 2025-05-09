package com.software.newbii.domain.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE member SET is_deleted = true, deleted_at = now() where id = ?")
@SQLRestriction("is_deleted is FALSE")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false, unique = true)
    private String email;

    @Column(nullable= false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable= false)
    private MemberRole role;

    @Column(nullable= false)
    private String name;

    private LocalDate birth;

    private String phone;

    private String oauthId;



}
