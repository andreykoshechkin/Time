package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(10);

        System.out.println("Start: " + start);

        int previousPercentage = -1; // Инициализируем предыдущий процент значением, которое не может быть достигнуто

        while (LocalDateTime.now().isBefore(end)) {
            try {
                // Пересчитываем общее количество секунд между start и end на каждой итерации
                long totalSeconds = Duration.between(start, end).getSeconds();

                // Вычисляем прошедшие секунды
                long elapsedSeconds = Duration.between(start, LocalDateTime.now()).getSeconds();

                // Вычисляем проценты
                long percentage = Math.round((double) elapsedSeconds / totalSeconds * 100);

                // Проверяем, отличается ли текущий процент от предыдущего
                if (percentage != previousPercentage) {
                    // Выводим проценты только если он изменился
                    System.out.println(percentage + " %");
                    // Обновляем значение предыдущего процента
                    previousPercentage = (int) percentage;
                }

                // Задержка до следующей секунды
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("End: " + LocalDateTime.now());
    }
}