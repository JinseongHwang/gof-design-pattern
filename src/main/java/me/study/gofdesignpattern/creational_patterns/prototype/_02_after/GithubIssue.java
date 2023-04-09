package me.study.gofdesignpattern.creational_patterns.prototype._02_after;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GithubIssue implements Cloneable {

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

    @Override
    public GithubIssue clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (GithubIssue)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
