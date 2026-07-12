public class RemoveAllWhiteSpacesInString {
    public static void main(String[] args) {
        String str1 = "    Al sabith berlin     ";

        String str2 = str1.trim();   //remove the white spaces from the starting and last of the string

        String str3 = str1.replaceAll("\\s" , "");  // this is the unicode , \s -> means single space so the single space replace by the nothing
        System.out.println(str1);  // original String

        System.out.println(str2);
        System.out.println(str3);

    }
}
