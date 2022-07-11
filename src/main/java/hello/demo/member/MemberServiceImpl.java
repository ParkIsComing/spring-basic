package hello.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //생성자 주입
    private final MemberRepository memberRepository;//DIP 만족. MemoryMemberRepository 이런건 밖에서 정해

    @Autowired
    //MemberServiceImple의 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부(AppConfig)에서 결정된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);//오버라이드한 MemoryMemberRepository의 save()가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return  memberRepository;
    }
}
