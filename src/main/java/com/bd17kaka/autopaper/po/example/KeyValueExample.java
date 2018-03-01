package com.bd17kaka.autopaper.po.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class KeyValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KeyValueExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andKey1IsNull() {
            addCriterion("key1 is null");
            return (Criteria) this;
        }

        public Criteria andKey1IsNotNull() {
            addCriterion("key1 is not null");
            return (Criteria) this;
        }

        public Criteria andKey1EqualTo(String value) {
            addCriterion("key1 =", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1NotEqualTo(String value) {
            addCriterion("key1 <>", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1GreaterThan(String value) {
            addCriterion("key1 >", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1GreaterThanOrEqualTo(String value) {
            addCriterion("key1 >=", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1LessThan(String value) {
            addCriterion("key1 <", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1LessThanOrEqualTo(String value) {
            addCriterion("key1 <=", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1Like(String value) {
            addCriterion("key1 like", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1NotLike(String value) {
            addCriterion("key1 not like", value, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1In(List<String> values) {
            addCriterion("key1 in", values, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1NotIn(List<String> values) {
            addCriterion("key1 not in", values, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1Between(String value1, String value2) {
            addCriterion("key1 between", value1, value2, "key1");
            return (Criteria) this;
        }

        public Criteria andKey1NotBetween(String value1, String value2) {
            addCriterion("key1 not between", value1, value2, "key1");
            return (Criteria) this;
        }

        public Criteria andValue1IsNull() {
            addCriterion("value1 is null");
            return (Criteria) this;
        }

        public Criteria andValue1IsNotNull() {
            addCriterion("value1 is not null");
            return (Criteria) this;
        }

        public Criteria andValue1EqualTo(String value) {
            addCriterion("value1 =", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotEqualTo(String value) {
            addCriterion("value1 <>", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThan(String value) {
            addCriterion("value1 >", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThanOrEqualTo(String value) {
            addCriterion("value1 >=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThan(String value) {
            addCriterion("value1 <", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThanOrEqualTo(String value) {
            addCriterion("value1 <=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Like(String value) {
            addCriterion("value1 like", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotLike(String value) {
            addCriterion("value1 not like", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1In(List<String> values) {
            addCriterion("value1 in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotIn(List<String> values) {
            addCriterion("value1 not in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Between(String value1, String value2) {
            addCriterion("value1 between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotBetween(String value1, String value2) {
            addCriterion("value1 not between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andPreIsNull() {
            addCriterion("pre is null");
            return (Criteria) this;
        }

        public Criteria andPreIsNotNull() {
            addCriterion("pre is not null");
            return (Criteria) this;
        }

        public Criteria andPreEqualTo(String value) {
            addCriterion("pre =", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotEqualTo(String value) {
            addCriterion("pre <>", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreGreaterThan(String value) {
            addCriterion("pre >", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreGreaterThanOrEqualTo(String value) {
            addCriterion("pre >=", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLessThan(String value) {
            addCriterion("pre <", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLessThanOrEqualTo(String value) {
            addCriterion("pre <=", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLike(String value) {
            addCriterion("pre like", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotLike(String value) {
            addCriterion("pre not like", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreIn(List<String> values) {
            addCriterion("pre in", values, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotIn(List<String> values) {
            addCriterion("pre not in", values, "pre");
            return (Criteria) this;
        }

        public Criteria andPreBetween(String value1, String value2) {
            addCriterion("pre between", value1, value2, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotBetween(String value1, String value2) {
            addCriterion("pre not between", value1, value2, "pre");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterionForJDBCDate("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterionForJDBCDate("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterionForJDBCDate("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterionForJDBCDate("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredIsNull() {
            addCriterion("gmt_expired is null");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredIsNotNull() {
            addCriterion("gmt_expired is not null");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_expired =", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredNotEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_expired <>", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredGreaterThan(Date value) {
            addCriterionForJDBCDate("gmt_expired >", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_expired >=", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredLessThan(Date value) {
            addCriterionForJDBCDate("gmt_expired <", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gmt_expired <=", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredIn(List<Date> values) {
            addCriterionForJDBCDate("gmt_expired in", values, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredNotIn(List<Date> values) {
            addCriterionForJDBCDate("gmt_expired not in", values, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gmt_expired between", value1, value2, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gmt_expired not between", value1, value2, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andTtlIsNull() {
            addCriterion("ttl is null");
            return (Criteria) this;
        }

        public Criteria andTtlIsNotNull() {
            addCriterion("ttl is not null");
            return (Criteria) this;
        }

        public Criteria andTtlEqualTo(Long value) {
            addCriterion("ttl =", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlNotEqualTo(Long value) {
            addCriterion("ttl <>", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlGreaterThan(Long value) {
            addCriterion("ttl >", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlGreaterThanOrEqualTo(Long value) {
            addCriterion("ttl >=", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlLessThan(Long value) {
            addCriterion("ttl <", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlLessThanOrEqualTo(Long value) {
            addCriterion("ttl <=", value, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlIn(List<Long> values) {
            addCriterion("ttl in", values, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlNotIn(List<Long> values) {
            addCriterion("ttl not in", values, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlBetween(Long value1, Long value2) {
            addCriterion("ttl between", value1, value2, "ttl");
            return (Criteria) this;
        }

        public Criteria andTtlNotBetween(Long value1, Long value2) {
            addCriterion("ttl not between", value1, value2, "ttl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}