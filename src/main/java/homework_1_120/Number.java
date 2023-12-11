package homework_1_120;

import java.util.Objects;

public class Number {
    Integer code;
    Integer number;
    public Number(Integer code, Integer number){
        setCode(code);
        setNumber(number);
    }
    public Integer getCode() {
        return code;
    }

    public Integer getNumber() {
        return number;
    }

    public void setCode(Integer code) {
        if(code < 10000 && code > 9){
            this.code = code;
        }else {
            throw  new IllegalArgumentException();
        }
    }

    public void setNumber(Integer number) {
        if (code.toString().length()>=4) {
            if (number <= 999999) {
                this.number = number;
            } else {
                throw new IllegalArgumentException();
            }
        }else {
            if (number <= 9999999) {
                this.number = number;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Number number1 = (Number) o;
        return Objects.equals(code, number1.code) && Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        StringBuilder sbNumber = new StringBuilder();
        sbNumber.append(number);
        sbNumber.reverse();
        if(code.toString().length()<4) {
            if (sbNumber.length() >= 7) {
                sbNumber.insert(2, "-");
                sbNumber.insert(5, "-");
            } else {
                while (sbNumber.length() != 7) {
                    sbNumber.append("0");
                }
                sbNumber.insert(2, "-");
                sbNumber.insert(5, "-");
            }
            sbNumber.reverse();
        }else {
            if (sbNumber.length() >= 6) {
                sbNumber.insert(2, "-");
                sbNumber.insert(5, "-");
            } else {
                while (sbNumber.length() != 6) {
                    sbNumber.append("0");
                }
                sbNumber.insert(2, "-");
                sbNumber.insert(5, "-");
            }
            sbNumber.reverse();
        }
        sb.append(code);
        sb.append(")");
        sb.append(sbNumber);
        return sb.toString();
    }
}
