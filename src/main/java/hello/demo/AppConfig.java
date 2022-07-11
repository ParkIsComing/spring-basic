package hello.demo;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.FixDisocuntPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//AppConfig의 역할
// 1. MemberServiceImpl이라는 객체를 생성
// 2. MemoryMemberRepository라는 구현 객체 생성
// 3. MemberServiceImple에 MemoryMemberRepository를 주입

@Configuration

public class AppConfig {
    //생성자 주입
    @Bean
    public MemberService memberService(){
        System.out.println("cal AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
        //역할이 드러나게 하려고
        // return new MemberServiceImpl(new MemoryMemberRepository());였던걸
        // extract method해서 아래의 memberRepository를 만든거임
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
//이것도 return new OrderServiceImpl(memberRepository() , new FixDisocuntPolicy());에서
//아래 discountPolicy추가하고
//new FixDisocuntPolicy()를 discountPolicy()로 바꿈

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository() , discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


}
