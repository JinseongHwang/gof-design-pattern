package me.study.gofdesignpattern.creational_patterns.prototype._01_before;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GithubIssue {

    private int id;
    private String title;
    private GithubRepository repository;

    public GithubIssue(GithubRepository repository) {
        this.repository = repository;
    }

    public String getUrl() {
        return String.format("https://github.com/%s/%s/issues/%d",
                             repository.getUser(),
                             repository.getName(),
                             this.getId()
        );
    }
}
