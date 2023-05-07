package hello_2303.core;

import hello_2303.core.discount.DiscountPolicy;
import hello_2303.core.discount.FixDiscountPolicy;
import hello_2303.core.discount.RateDiscountPolicy;
import hello_2303.core.member.MemberRepository;
import hello_2303.core.member.MemberService;
import hello_2303.core.member.MemberServiceImpl;
import hello_2303.core.member.MemoryMemberRepository;
import hello_2303.core.order.OrderService;
import hello_2303.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 구성정보 (설정정보)
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //생성자 주입
    }

    @Bean
    public DiscountPolicy discountPolicy(){

//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
