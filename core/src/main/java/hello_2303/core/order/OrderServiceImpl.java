package hello_2303.core.order;

import hello_2303.core.discount.DiscountPolicy;
import hello_2303.core.discount.FixDiscountPolicy;
import hello_2303.core.discount.RateDiscountPolicy;
import hello_2303.core.member.Member;
import hello_2303.core.member.MemberRepository;
import hello_2303.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
