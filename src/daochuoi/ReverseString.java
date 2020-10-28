/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daochuoi;

/**
 *
 * @author lamit
 */


public class ReverseString {

    private String _string;
// khoi tao khong tham so

    public ReverseString() {
    }
// khoi tao co tham so

    public ReverseString(String _string) {
        this._string = _string;
    }

    public String get_string() {
        return _string;
    }

    public void set_string(String _string) {
        this._string = _string;
    }

    public void reverse() {
        String tmp = "";
        for (int i = _string.length() - 1; i >= 0; i--) {
            tmp += _string.substring(i, i + 1);
        }
        this._string = tmp;
    }
}
