package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private OrderService orderService = new OrderServiceImpl();
    private DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberService memberService = new MemberServiceImpl();
    @Test
    void createOrder() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        Member findMember = memberRepository.findById(1L);
        int discountPrice = discountPolicy.discount(findMember, 20000);
        //when
        Order order = orderService.createOrder(member.getId(), "itemA", 20000);
        //then
        Assertions.assertThat(order.calculatePrice()).isEqualTo(2000);
    }
}
