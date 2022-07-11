package hello.demo.order;

import hello.demo.discount.DiscountPolicy;
import hello.demo.member.Member;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;//DIP(의존관계 역전 원칙) 만족

//    아래의 방식은 DIP 위반
//    private final DiscountPolicy discountPolicy = new FixDisocuntPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//주문 들어오면 먼저 회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);//discountPolicy에 그냥 회원정보 넘겨서 얘가 알아서 할인가격 도출하도록
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
