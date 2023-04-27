package hello_2303.core;

import hello_2303.core.discount.DiscountPolicy;
import hello_2303.core.discount.FixDiscountPolicy;
import hello_2303.core.member.MemberRepository;
import hello_2303.core.member.MemberService;
import hello_2303.core.member.MemberServiceImpl;
import hello_2303.core.member.MemoryMemberRepository;
import hello_2303.core.order.OrderService;
import hello_2303.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //생성자 주입
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
