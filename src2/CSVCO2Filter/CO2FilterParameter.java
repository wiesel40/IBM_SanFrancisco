
package CSVCO2Filter;

/**
 This class provides getter and setter methods for 
 Department , Emissions_mtCO2e , m_SourceType
 */
public class CO2FilterParameter {

    private String m_Department;
    private String m_Emissions_mtCO2e;
    private String m_SourceType;

    public String getM_Department() {
        return m_Department;
    }

    public void setM_Department(String m_Department) {
        this.m_Department = m_Department;
    }

    public String getM_Emissions_mtCO2e() {
        return m_Emissions_mtCO2e;
    }

    public void setM_Emissions_mtCO2e(String m_Emissions_mtCO2e) {
        this.m_Emissions_mtCO2e = m_Emissions_mtCO2e;
    }

    public String getM_SourceType() {
        return m_SourceType;
    }

    public void setM_SourceType(String m_SourceType) {
        this.m_SourceType = m_SourceType;
    }

    public CO2FilterParameter() {

    }

    public CO2FilterParameter(String p_Department, String p_SourceType, String p_Emissions_mtCO2e) {
        this.m_Department = p_Department;
        this.m_Emissions_mtCO2e = p_Emissions_mtCO2e;
        this.m_SourceType = p_SourceType;
    }
}
