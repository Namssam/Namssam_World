

import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from ADR_A import ADR_A

form_class = uic.loadUiType("ADR_D.ui")[0] # ui명 매우 중요!!

class ADR_D(QDialog, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self) # 화면 셋업

    # 총 합계 불러오기에 대한 함수
    def CallTotal(self):
        Af_total = ADR_A().Af_total() # ADR_A의 Af_total()함수를 불러옴(return값이 합계 금액임)
        self.lbl_total.setText('현재 총 합계 금액은 %d원 입니다.' %Af_total) # 얘 어떻게 해야되지?(다른 파일에서 불러오려면)

    # 더치페이 버튼에 대한 함수
    def Dutchpay(self):

        if self.txt_count.toPlainText() == '':
            QMessageBox.about(self, 'message', '입력된 내용이 없습니다!')
        else:         
            Af_total = ADR_A().Af_total()
            dutch_result = int(Af_total) // int(self.txt_count.toPlainText()) 
            self.lbl_dutch_result.setText('각자 내야할 금액은 %d원 입니다.' %dutch_result)


if __name__ == '__main__':
    app = QApplication(sys.argv) 
    demoWindow = ADR_D()
    demoWindow.show()
    app.exec_()









