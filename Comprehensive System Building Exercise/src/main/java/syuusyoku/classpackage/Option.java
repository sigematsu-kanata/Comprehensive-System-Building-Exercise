package syuusyoku.classpackage;

public class Option {
	/**
     * 全角数字を半角数字に変換します。
     * 
     * @param input 変換対象の文字列
     * @return 変換後の文字列（nullの場合はnullを返します）
     */
    public static String zenkakuToHankakuNum(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }
        String emg = "";
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 全角数字 '０' (U+FF10) 〜 '９' (U+FF19) の範囲内か判定
            if (c >= '０' && c <= '９') {
                // 文字コードの差分を引き算して半角化
                chars[i] = (char) (c - '０' + '0');
            } else if (c >= '0' && c <= '9') {
                // すでに半角数字の場合は何もしない（そのまま保持）
                continue;
            } else {
                // 数字（全角・半角）以外の文字が含まれていたらエラーを投げる
                emg = "error";
                break;
            }
        }
        String a = new String(chars);
        if(emg.equals(""))
        	return a;
        else {
        	return emg;
        }
    }
}