package hello.demo.discount;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){//할인되는 가격을 계산해서 리턴해야지 OrderServiceImpl 영향 안 주면서 계산 가능
            return price *discountPercent/100;
        }
        else{
            return 0;
        }

    }
}
