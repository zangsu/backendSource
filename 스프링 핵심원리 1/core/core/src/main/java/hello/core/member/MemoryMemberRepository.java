package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository{

    //private static Map<Long, Member> store = new ConcurrentHashMap<>();
    //얘는 동시성이슈 때문에 사용하는 HashMap
    // 동시성 이슈란 동시에 여러군데서 얘한테 접근하는것
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
