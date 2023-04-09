package me.study.gofdesignpattern.creational_patterns.prototype._02_after;

public class App {

    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("whiteship");
        repository.setName("live-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

        String url = githubIssue.getUrl();
        System.out.println(url);

        // 객체 복제하기
        GithubIssue clone = githubIssue.clone();
        System.out.println(clone.getUrl());

        System.out.println(githubIssue != clone); // 객체 레퍼런스는 다르다.
        System.out.println(githubIssue.equals(clone)); // 객체 내부 값은 동일하다.
        System.out.println(githubIssue.getClass() == clone.getClass()); // 클래스 타입도 동일하다.
        System.out.println(githubIssue.getRepository() == clone.getRepository()); // shallow copy이기 때문에 동일한 레퍼런스를 가진다.

        clone.getRepository().setName("FOO"); // 복제본에서 레퍼런스 조작을 하면
        System.out.println(githubIssue.getRepository().getName()); // 원본에도 변화가 생긴다.
    }
}
