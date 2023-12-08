
class POJO {
    private int value = 40;

    public int getValue() {
        return value;
    }

    private int setValue(int value) {
        return this.value = value;
    }
}

class Classes {
    public static void main(String args[]) {
        
        for (String arg : args) {
            System.out.println(arg);
        }
    }

}
