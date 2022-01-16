

import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from ADR_A import ADR_A

form_class = uic.loadUiType("ADR_T.ui")[0] # ui명 매우 중요!!

class ADR_T(QDialog, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self) # 화면 셋업

    # 조회 버튼 클릭에 대한 함수
    def Check(self):
        t_result = ADR_A().Af_total() # ADR_A의 Af_total()함수를 불러옴(return값이 합계 금액임)
        self.lbl_total.setText('현재 총 합계 금액은  %d원 입니다.' %t_result)
  


if __name__ == '__main__':
    app = QApplication(sys.argv) 
    demoWindow = ADR_T()
    demoWindow.show()
    app.exec_()









