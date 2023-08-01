package pl.coderslab.dao;

import pl.coderslab.model.DayName;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pl.coderslab.utils.DbUtil.getConnection;

public class DayNameDao {
    private static final String GET_ALL_DAYS_WITH_ORDER = "SELECT * FROM day_name";

    public List<DayName> findAll() {
        List<DayName> dayNameList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_DAYS_WITH_ORDER);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                DayName dayToAdd = new DayName();
                dayToAdd.setId(resultSet.getInt("id"));
                dayToAdd.setName(resultSet.getString("name"));
                dayToAdd.setDisplayOrder(resultSet.getInt("display_order"));
                dayNameList.add(dayToAdd);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dayNameList;

    }

}
