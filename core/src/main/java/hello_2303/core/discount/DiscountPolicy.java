package hello_2303.core.discount;

import hello_2303.core.member.Member;

public interface DiscountPolicy {

    /*
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
