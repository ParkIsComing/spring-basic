package hello.demo.member;
//회원가입과 회원조회 구현
public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
