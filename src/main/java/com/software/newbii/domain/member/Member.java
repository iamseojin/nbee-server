package com.software.newbii.domain.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@Builder
@AllArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guardian_id")
    private Member guardian;

    @OneToOne(mappedBy = "guardian", fetch = FetchType.LAZY)
    private Member user;

    public void assignUser(Member user) {
        if (this.role != MemberRole.GUARDIAN) {
            throw new IllegalStateException("피보호자를 지정할 수 있는 권한이 없습니다.");
        }
        this.user = user;
        user.guardian = this;
    }



}
