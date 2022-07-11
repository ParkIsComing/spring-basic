package hello.demo;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        //MemberService 객체 생성하고 AppConfig에서 만든 MemoryMemberService 객체 주입
//        MemberService memberService = appConfig.memberService();

        //AppConfig에 있는 환경설정 정보를 갖고 그 안에서 만드는 객체들을 스프링 컨테이너에 집어넣음
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//메소드이름, 가져올 타입 파라미터로해서 가져옴


        Member member = new Member(1L, "memberA", Grade.VIP);//Member객체 만들어서
        memberService.join(member);//가입시키고

        Member findMember = memberService.findMember(1L);//findMember로 가입 잘 됐는지 조회
        System.out.println("find Member:" +findMember.getName());//sout 찍어서 둘이 같은지 확인
        System.out.println("new member :" + member.getName());

    }
}
