package org.example.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.reggie.dao.AddressBookDao;
import org.example.reggie.entity.AddressBook;
import org.example.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookDao, AddressBook> implements AddressBookService {
}
