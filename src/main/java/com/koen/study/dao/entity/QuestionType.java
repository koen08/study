package com.koen.study.dao.entity;

public enum QuestionType {
    MULTIPLE {
        @Override
        public boolean checkCorrectAnswer(String[] answers, String[] expectedAnswers) {
            int counterExpectedAnswers = 0;
            for (String answer : answers) {
                for (String expectedAnswer : expectedAnswers) {
                    if (!answer.equals(expectedAnswer)) {
                        continue;
                    } else {

                    }
                }
            }
            return false;
        }
    },
    SINGLE {
        @Override
        public boolean checkCorrectAnswer(String[] answers, String[] expectedAnswers) {
            if (answers.length == 1) {
                return answers[0].equals(expectedAnswers[0]);
            }
            return false;
        }
    },
    FREE_ANSWER {
        @Override
        public boolean checkCorrectAnswer(String[] answers, String[] expectedAnswers) {
            return false;
        }
    };

    public abstract boolean checkCorrectAnswer(String[] answers, String[] expectedAnswers);
}
