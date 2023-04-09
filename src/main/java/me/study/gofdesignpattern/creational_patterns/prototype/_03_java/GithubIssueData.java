package me.study.gofdesignpattern.creational_patterns.prototype._03_java;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GithubIssueData {

    private int id;
    private String title;
    private String repositoryUser;
    private String repositoryName;
}
