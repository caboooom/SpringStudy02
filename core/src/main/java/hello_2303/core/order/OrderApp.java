package hello_2303.core.order;

import hello_2303.core.AppConfig;
import hello_2303.core.MemberApp;
import hello_2303.core.member.Grade;
import hello_2303.core.member.Member;
import hello_2303.core.member.MemberService;
import hello_2303.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
    }
}
