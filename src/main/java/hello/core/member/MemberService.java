package hello.core.member;

public interface MemberService {

    void join(Member memberId);

    Member findMember(Long memberId);

}
