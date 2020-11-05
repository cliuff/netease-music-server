package cn.edu.cqut.cat.se.nemu.service;

import cn.edu.cqut.cat.se.nemu.entity.Artist;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface IArtistService extends IService<Artist> {


    DataResponse getSortCounts();

    DataResponse getCountByMonth();
}
