package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        Member member1 = new Member(2L, "memberB", Grade.BASIC);
        //when
        memberService.join(member);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        Member findMember2 = memberService.findMember(2L);
        //then
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        Assertions.assertThat(member1.getName()).isEqualTo(findMember2.getName());
    }
}
