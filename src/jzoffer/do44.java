package jzoffer;

public class do44 {
    /**
     * 获取place位数中，第index个数
     * @param index
     * @param place
     * @return
     */
    public int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index/place;
        String number = (beginNumber+shiftNumber)+"";
        int count = index%place;
        return number.charAt(count)-'0';
    }

    /**
     * 获取place位数的起始位置
     * 0,10,100,1000
     * @param place
     * @return
     */
    private int getBeginNumberOfPlace(int place) {
        if(place==1)
            return 0;
        return (int) Math.pow(10,place-1);
    }


    public int getDigitAtIndex(int index) {
        if(index<0)
            return -1;
        int place = 1;
        while(true) {
            int amount = getAmountOfPlace(place);
            int totalAmount = amount*place;
            if(index<totalAmount)
                return getDigitAtIndex(index,place);
            index -= totalAmount;
            place++;
        }
    }

    /**
     * place位数的数字组成的字符串长度：10，90，900
     * @param place
     * @return
     */
    private int getAmountOfPlace(int place) {
        if(place==1)
            return 10;
        return (int) (Math.pow(10,place-1)*9);
    }
}
