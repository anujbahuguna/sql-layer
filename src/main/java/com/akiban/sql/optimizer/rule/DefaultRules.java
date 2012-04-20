/**
 * END USER LICENSE AGREEMENT (“EULA”)
 *
 * READ THIS AGREEMENT CAREFULLY (date: 9/13/2011):
 * http://www.akiban.com/licensing/20110913
 *
 * BY INSTALLING OR USING ALL OR ANY PORTION OF THE SOFTWARE, YOU ARE ACCEPTING
 * ALL OF THE TERMS AND CONDITIONS OF THIS AGREEMENT. YOU AGREE THAT THIS
 * AGREEMENT IS ENFORCEABLE LIKE ANY WRITTEN AGREEMENT SIGNED BY YOU.
 *
 * IF YOU HAVE PAID A LICENSE FEE FOR USE OF THE SOFTWARE AND DO NOT AGREE TO
 * THESE TERMS, YOU MAY RETURN THE SOFTWARE FOR A FULL REFUND PROVIDED YOU (A) DO
 * NOT USE THE SOFTWARE AND (B) RETURN THE SOFTWARE WITHIN THIRTY (30) DAYS OF
 * YOUR INITIAL PURCHASE.
 *
 * IF YOU WISH TO USE THE SOFTWARE AS AN EMPLOYEE, CONTRACTOR, OR AGENT OF A
 * CORPORATION, PARTNERSHIP OR SIMILAR ENTITY, THEN YOU MUST BE AUTHORIZED TO SIGN
 * FOR AND BIND THE ENTITY IN ORDER TO ACCEPT THE TERMS OF THIS AGREEMENT. THE
 * LICENSES GRANTED UNDER THIS AGREEMENT ARE EXPRESSLY CONDITIONED UPON ACCEPTANCE
 * BY SUCH AUTHORIZED PERSONNEL.
 *
 * IF YOU HAVE ENTERED INTO A SEPARATE WRITTEN LICENSE AGREEMENT WITH AKIBAN FOR
 * USE OF THE SOFTWARE, THE TERMS AND CONDITIONS OF SUCH OTHER AGREEMENT SHALL
 * PREVAIL OVER ANY CONFLICTING TERMS OR CONDITIONS IN THIS AGREEMENT.
 */

package com.akiban.sql.optimizer.rule;

import java.util.Arrays;
import java.util.List;

public class DefaultRules
{
    /** These are the rules that get run for normal compilation. */
    public static final List<BaseRule> DEFAULT_RULES = Arrays.asList(
        // These aren't singletons because someday they will have options.
        new ASTStatementLoader(),
        new AggregateMapper(),
        new AggregateToDistinctMapper(),
        new ConstantFolder(),
        new OuterJoinPromoter(),
        new ColumnEquivalenceFinder(),
        new GroupJoinFinder(),
        new InConditionReverser(),
        new IndexPicker(),
        new NestedLoopMapper(),
        new BranchJoiner(),
        new SelectPreponer(),
        new AggregateSplitter(),
        new SortSplitter(),
        new MapFolder(),
        new ExpressionCompactor(),
        new OperatorAssembler()
     );

    /** These are the rules that get run for CBO compilation. */
    public static final List<BaseRule> DEFAULT_RULES_CBO = Arrays.asList(
        // These aren't singletons because someday they will have options.
        new ASTStatementLoader(),
        new AggregateMapper(),
        new AggregateToDistinctMapper(),
        new ConstantFolder(),
        new OuterJoinPromoter(),
        new ColumnEquivalenceFinder(),
        new GroupJoinFinder_CBO(),
        new InConditionReverser(),
        new JoinAndIndexPicker(),
        new NestedLoopMapper(),
        new BranchJoiner_CBO(),
        new SelectPreponer(),
        new AggregateSplitter(),
        new SortSplitter(),
        new MapFolder(),
        new ExpressionCompactor(),
        new OperatorAssembler()
     );

    private DefaultRules() {
    }
}
