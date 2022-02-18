from service.ths import ThsIndustryCapture
from service.em_zdt import EmZdtCapture
ths = ThsIndustryCapture()
# ThsIndustryCapture.all_industry(ths)
# ThsIndustryCapture.all_index_to_sql(ths)

em = EmZdtCapture()
# EmZdtCapture.all_em_zt(em)
EmZdtCapture.all_em_dt(em)

