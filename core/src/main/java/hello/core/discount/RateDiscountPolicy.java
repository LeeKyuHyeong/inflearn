package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    
    private int rateDiscountAmount = 10; //10퍼센트
    
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * rateDiscountAmount / 100;
        } else {
            return 0;
        }
    }
}
