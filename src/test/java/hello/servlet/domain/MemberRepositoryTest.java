package hello.servlet.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void AfterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll(){
        Member member = new Member("hello1", 10);
        Member member2 = new Member("hello2", 10);

        memberRepository.save(member);
        memberRepository.save(member2);

        List<Member> list = memberRepository.findAll();

        assertThat(list.size()).isEqualTo(2);
        assertThat(list).contains(member, member2);

    }
}
