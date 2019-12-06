
package statistics;

import statistics.matcher.*;

public class QueryBuilder {
    
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public Matcher build() {
        Matcher result = matcher;
        matcher = new All();
        return result;
    }
    
}
