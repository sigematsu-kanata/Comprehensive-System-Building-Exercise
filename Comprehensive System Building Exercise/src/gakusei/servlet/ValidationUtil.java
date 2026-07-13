package gakusei.servlet;

/**
 * 画面入出力項目一覧・アクション定義書に定義された入力チェックをまとめたユーティリティ。
 */
public class ValidationUtil {

    private ValidationUtil() {
    }

    /** nullまたは空文字なら未入力とみなす */
    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    /** 数字列（半角数字のみ）かどうか（学籍番号・出席番号用） */
    public static boolean isNumeric(String s) {
        return s != null && s.matches("^[0-9]+$");
    }

    /** 平仮名（全角）のみかどうか（読み仮名入力欄用） */
    public static boolean isHiragana(String s) {
        return s != null && s.matches("^[\u3040-\u309F]+$");
    }

    /** 全角文字のみで構成されているか（半角英数字を含まないか）の簡易チェック（検索欄用） */
    public static boolean isZenkaku(String s) {
        if (s == null) {
            return true;
        }
        return s.matches("^[^\\x01-\\x7E\\uFF61-\\uFF9F]*$");
    }
}
