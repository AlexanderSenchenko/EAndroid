package com.example.eltex.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TODO:
 * 1. Тесты для обратной польской записи
 * 2. Поддержать деление
 * 3. Стиль
 */

public class MainActivity extends AppCompatActivity {

    LinkedList<String> input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = new LinkedList<>();

        ((Button) findViewById(R.id.zero)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.one)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.two)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.three)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.four)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.five)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.six)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.seven)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.eight)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.nine)).setOnClickListener((view) -> {
            processDigit((TextView) view);
        });

        ((Button) findViewById(R.id.plus)).setOnClickListener((view) -> {
            processOperator((TextView) view);
        });

        ((Button) findViewById(R.id.minus)).setOnClickListener((view) -> {
            processOperator((TextView) view);
        });

        ((Button) findViewById(R.id.multiply)).setOnClickListener((view) -> {
            processOperator((TextView) view);
        });

//        TODO:
//        ((Button) findViewById(R.id.div)).setOnClickListener((view) -> {
//            processOperator((TextView) view);
//        });

        ((Button) findViewById(R.id.pl)).setOnClickListener((view) -> {
            processOperator((TextView) view);
        });

        ((Button) findViewById(R.id.lr)).setOnClickListener((view) -> {
            processOperator((TextView) view);
        });

        ((Button) findViewById(R.id.qe)).setOnClickListener((view) -> {
            String res = calc(input).toString();

            setInput(res);
            setOutput("");

            input.clear();
            input.add(res);

            System.out.println("Input: " + input);
        });

        ((Button) findViewById(R.id.erase)).setOnClickListener(view -> {
            if (!input.isEmpty()) {
                input.removeLast();

                setInput("");
                for (String token : input) {
                    addInput(token);
                }
            }

            System.out.println("Input: " + input);
        });

        ((Button) findViewById(R.id.clear)).setOnClickListener(view -> {
            input.clear();
            setInput("");
            setOutput("");

            System.out.println("Input: " + input);
        });
    }

    public void processDigit(TextView button) {
        input.add(button.getText().toString());

        addInput(button.getText().toString());
        setOutput(calc(input).toString());

        System.out.println("Input: " + input);
    }

    public void processOperator(TextView button) {
        input.add(button.getText().toString());

        addInput(button.getText().toString());

        System.out.println("Input: " + input);
    }

    public Double calc(LinkedList<String> input) {
        List<String> operators = Arrays.asList("+", "-", "*", "/", "(", ")");
        LinkedList<String> list = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();

        for (String token : input) {
            if (operators.contains(token)) {
                if (token.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        list.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (!stack.empty()
                            && (token.equals("+") || token.equals("-"))
                            && (stack.peek().equals("+")
                            || stack.peek().equals("-")
                            || stack.peek().equals("*")
                            || stack.peek().equals("/"))) {
                        list.add(stack.pop());
                    } else if (!stack.empty()
                            && (token.equals("*") || token.equals("/"))
                            && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        list.add(stack.pop());
                    }

                    stack.push(token);
                }
            } else {
                list.add(token);
            }
        }

        while (!stack.empty()) {
            list.add(stack.pop());
        }

        Stack<Double> stack2 = new Stack<Double>();

        for (String token : list) {
            if (operators.contains(token)) {
                double x2 = stack2.pop();
                double x1 = stack2.pop();

                switch (token) {
                    case "+": stack2.push(x1 + x2); break;
                    case "-": stack2.push(x1 - x2); break;
                    case "*": stack2.push(x1 * x2); break;
                    case "/": stack2.push(x1 / x2); break;
                    default: break;
                }
            } else {
                stack2.push(Double.valueOf(token));
            }
        }

        return stack2.pop();
    }

    public void setInput(String text) {
        ((TextView) findViewById(R.id.input)).setText(text);
    }

    public void setOutput(String text) {
        ((TextView) findViewById(R.id.output)).setText(text);
    }

    public void addInput(String text) {
        TextView output = (TextView) findViewById(R.id.input);

        output.setText(output.getText() + text);
    }

 }