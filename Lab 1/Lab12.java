import java.util.*;
import java.io.*;
import java.lang.Character;

class Lab12 {
 public static void main(String[] args) throws IOException {
  File x = new File (args [0]);
  String source = readFile(x);
  tokenize(source);
 }
 public static String readFile(File x) throws IOException {
  FileReader in = new FileReader(x);
  int size = (int) x.length();
  char[] data = new char[size]; in .read(data); in .close();
  return new String(data);
 }
 public static void tokenize(String source) {
  StringTokenizer st = new StringTokenizer(source);
  int curTkn = 0;
  while (st.hasMoreTokens()) {
   String token = st.nextToken();
   if (isPseudoOpCode(token)) {
    System.out.println(token + " is a pseudo op code");
   } else if (isOpCode(token)) {
    System.out.println(token + " is an op code");
   } else if (isNumber(token)) {
    System.out.println(token + " is a number");
   } else if (isLabel(token)) {
    System.out.println(token + " is a label");
   } else if (isOperand(token)) {
    System.out.println(token + " is an operand");
   } else {
    System.out.println(token + " is invalid");
   }
  }
 }
 public static boolean isPseudoOpCode(String word) {
  if (word.equals(".begin") || word.equals(".end") || word.equals(".data")) {
   return true;
  }
  return false;
 }
 public static boolean isOpCode(String word) {
  if (word.equals("LOAD")) {
   return true;
  } else if (word.equals("STORE")) {
   return true;
  } else if (word.equals("CLEAR")) {
   return true;
  } else if (word.equals("ADD")) {
   return true;
  } else if (word.equals("INCREMENT")) {
   return true;
  } else if (word.equals("SUBTRACT")) {
   return true;
  } else if (word.equals("DECREMENT")) {
   return true;
  } else if (word.equals("COMPARE")) {
   return true;
  } else if (word.equals("JUMP")) {
   return true;
  } else if (word.equals("JUMPGT")) {
   return true;
  } else if (word.equals("JUMPEQ")) {
   return true;
  } else if (word.equals("JUMPLT")) {
   return true;
  } else if (word.equals("JUMPNEQ")) {
   return true;
  } else if (word.equals("IN")) {
   return true;
  } else if (word.equals("OUT")) {
   return true;
  } else if (word.equals("HALT")) {
   return true;
  }
  return false;
 }
 public static boolean isOperand(String word) {
  boolean valid = true;

  for (int i = 0; i < word.length() - 1; i++) {
   char currentLetter = word.charAt(i);
   if (!isLetter(currentLetter)) {
    valid = false;
    break;
   }
  }
  return valid;
 }
 public static boolean isLabel(String word) {
  boolean allLetters = true;
  for (int i = 0; i < word.length() - 2; i++) {
   char currentLetter = word.charAt(i);
   if (!isLetter(currentLetter)) {
    allLetters = false;
    break;
   }
  }
  if (word.charAt(word.length() - 1) == ':' && allLetters) {
   return true;
  }
  return false;
 }
 public static boolean isNumber(String word) {
  for (int i = 0; i < word.length(); i++) {
   char currentChar = word.charAt(i);
   if (!isDigit(currentChar)) {
    return false;
   }
  }
  return true;
 }
 public static boolean isLetter(char c) {
  return Character.isLetter(c);
 }
 public static boolean isDigit(char c) {
  return Character.isDigit(c);
 }
}