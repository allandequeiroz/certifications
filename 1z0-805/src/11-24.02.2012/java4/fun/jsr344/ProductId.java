package java4.fun.jsr344;

public class ProductId {

    public static int getProductId(String productName) {

        int productId = -1;
        if(productName==null){return 1;}

        switch(productName){
            case "SCJP 5 Training Lab":productId=1;break;
            case "SCJP 6 Training Lab":productId=2;break;
            case "SCJP 7 Training Lab":productId=3;break;
            case "OCA Java SE 7 Training Lab":productId=4;break;
            default:productId=-1;break;
        }
        
        return productId;
    }
    
    public static void main(String...args){
        String productName = "OCA Java SE 7 Training Lab";
        int productId = getProductId(productName);
        if(productId==-1){
            System.out.println("invalid produc");
        }else{
            System.out.println(productId);
        }
    }
}
