package hello.core.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int  discountPrice;

    public Order(Long memberid, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberid;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    public void setMemberid(Long memberid) {
        this.memberId = memberid;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Long getMemberid() {
        return memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId = " + memberId +
                ", itemName = '" + itemName + '\'' +
                ", itemPrice = '" + itemPrice + '\'' +
                ", discountPrice = '" + discountPrice +
                "}";
    }

}
