package geektime.spring.data.mybatisdemo.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoneyTypeHandler extends BaseTypeHandler<Money> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Money parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, parameter.getAmountMinorLong());
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return parseMoney(resultSet.getLong(columnName));
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return parseMoney(resultSet.getLong(columnIndex));
    }

    @Override
    public Money getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return parseMoney(callableStatement.getLong(columnIndex));
    }

    private Money parseMoney(long value) {
        return Money.of(CurrencyUnit.of("CNY"), value / 100.0);
    }
}
