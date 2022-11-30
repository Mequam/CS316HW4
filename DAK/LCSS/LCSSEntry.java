package DAK.LCSS;

class LCSSEntry {
    public LCSSEntry () {

    }
    int pointerX = 0;
    int pointerY = 0;
    int value = 0;
    @Override
    public String toString() {

        return Integer.toString(value);
       // String ret_val = "";
       // if (pointerX != 0 && pointerY!= 0) {
           // ret_val += "\\";
       // } else {
           // if (pointerX != 0) {
               // ret_val += "<";
           // }
           // if (pointerY != 0) {
               // ret_val += "^";
           // }
       // }
       // ret_val += Integer.toString(value);
       // return ret_val;
    
    }
}