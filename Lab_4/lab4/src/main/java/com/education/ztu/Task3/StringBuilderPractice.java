package com.education.ztu.Task3;

public class StringBuilderPractice {
    public static void main(String[] args) {
        int a = 4;
        int b = 36;

        StringBuilder addResult= new StringBuilder();
        addResult.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println(addResult);

        StringBuilder subtractionResult = new StringBuilder();
        subtractionResult.append(a).append(" - ").append(b).append(" = ").append(a - b);
        System.out.println(subtractionResult);

        StringBuilder multiplicationResult = new StringBuilder();
        multiplicationResult.append(a).append(" * ").append(b).append(" = ").append(a * b);
        System.out.println(multiplicationResult);


        StringBuilder additionModified = new StringBuilder(addResult);
        int equalSignIndex = additionModified.indexOf("=");
        additionModified.deleteCharAt(equalSignIndex).insert(equalSignIndex, "рівно");
        System.out.println("Замінено \"=\" на \"рівно\": " + additionModified);


        StringBuilder subtractionModified = new StringBuilder(subtractionResult);
        equalSignIndex = subtractionModified.indexOf("=");
        subtractionModified.replace(equalSignIndex, equalSignIndex + 1, "рівно");
        System.out.println("Замінено \"=\" на \"рівно\": " + subtractionModified);


        StringBuilder reversed = new StringBuilder(multiplicationResult).reverse();
        System.out.println("Реверс рядка: " + reversed);


        System.out.println("Довжина рядка: " + addResult.length());
        System.out.println("Ємність (capacity) рядка: " + addResult.capacity());
    }
}
