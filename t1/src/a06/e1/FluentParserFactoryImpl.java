package a06.e1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.function.UnaryOperator;

public class FluentParserFactoryImpl implements FluentParserFactory {

    @Override
    public FluentParser<Integer> naturals() {
        return new FluentParser<Integer>() {
            int value;

            public void setValue(int value) {
                this.value = value;
            }

            @Override
            public FluentParser<Integer> accept(Integer value) {
                if (this.value == 0 || this.value != value) {
                    setValue(value);
                    return this;
                } else {
                    throw new IllegalStateException();
                }
            }

        };
    }

    @Override
    public FluentParser<List<Integer>> incrementalNaturalLists() {
        return new FluentParser<List<Integer>>() {
            List<Integer> list = new ArrayList<>();

            @Override
            public FluentParser<List<Integer>> accept(List<Integer> value) {
                Integer last = 0;
                if (!list.isEmpty()) {
                    last = this.list.stream().sorted().toList().getLast();
                }

                if (last == 0 || last == value.getLast() - 1) {
                    this.list.addAll(value);
                    return this;
                } else {
                    throw new IllegalStateException();
                }
            }

        };
    }

    @Override
    public FluentParser<Integer> repetitiveIncrementalNaturals() {
        return new FluentParser<Integer>() {
            int value;        

            public void setValue(int value) {
                this.value = value;
            }

            @Override
            public FluentParser<Integer> accept(Integer value) {
                var test = new LinkedList<>();

                
                if (this.value == 0 || this.value != value - 1 ) {
                    setValue(value);
                    for (int i = 0 ; i <= value ; i++){
                        test.

                    }
                    return this;
                } else {
                    throw new IllegalStateException();
                }
            }
            };
            
        };

    @Override
    public FluentParser<String> repetitiveIncrementalStrings(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'repetitiveIncrementalStrings'");
    }

    @Override
    public FluentParser<Pair<Integer, List<String>>> incrementalPairs(int i0, UnaryOperator<Integer> op, String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incrementalPairs'");
    }

}
