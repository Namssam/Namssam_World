
# 안주 및 주류 입력 현황 조회창

import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic


form_class = uic.loadUiType("ADR_A_status.ui")[0] # ui명 매우 중요!!

class ADR_A_status(QDialog, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self) # 화면 셋업

    # ADR_A에서 조회현황을 불러오기 위한 함수
    def Label_update(self, drink, food):
        # setText()에는 str만 들어갈 수 있는 듯
        return self.lbl_drink_dict.setText(str(drink)), self.lbl_food_dict.setText(str(food))


if __name__ == '__main__':
    app = QApplication(sys.argv) 
    demoWindow = ADR_A_status()
    demoWindow.show()
    app.exec_()









